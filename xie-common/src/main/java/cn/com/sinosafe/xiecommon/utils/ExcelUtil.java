package cn.com.sinosafe.xiecommon.utils;

import cn.com.sinosafe.xiecommon.annotation.Excel;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor.HSSFColorPredefined;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Excel相关处理
 *
 * @author sinosafe
 */
public class ExcelUtil<T> {
//    private static final Logger log = LoggerFactory.getLogger(ExcelUtil.class);

    /**
     * Excel sheet最大行数，默认65536
     */
    private static final int SHEETSIZE = 65536;
    /**
     * 工作表名称
     */
    private String sheetName;

    /**
     * 导出类型（EXPORT:导出数据；IMPORT：导入模板）
     */
    private Excel.Type type;

    /**
     * 工作薄对象
     */
    private Workbook wb;

    /**
     * 工作表对象
     */
    private Sheet sheet;

    /**
     * 导入导出数据列表
     */
    private List<T> list;

    /**
     * 注解列表
     */
    private List<Field> fields;

    public Class<T> clazz;

    public ExcelUtil(Class<T> clazz) {
        this.clazz = clazz;
    }

    private void init(List<T> list, String sheetName, Excel.Type type) {
        if (list == null) {
            list = new ArrayList<T>();
        }
        this.list = list;
        this.sheetName = sheetName;
        this.type = type;
        createExcelField();
        createWorkbook();
    }

    /**
     * 得到所有定义字段
     */
    private void createExcelField() {
        this.fields = new ArrayList<Field>();
        List<Field> tempFields = new ArrayList<Field>();
        Class<?> tempClass = clazz;
        tempFields.addAll(Arrays.asList(clazz.getDeclaredFields()));
        while (tempClass != null) {
            tempClass = tempClass.getSuperclass();
            if (tempClass != null) {
                tempFields.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            }
        }
        putToFields(tempFields);
    }

    /**
     * 放到字段集合中
     */
    private void putToFields(List<Field> fields) {
        for (Field field : fields) {
            Excel attr = field.getAnnotation(Excel.class);
            if (attr != null && (attr.type() == Excel.Type.ALL || attr.type() == type)) {
                this.fields.add(field);
            }
        }
    }

    /**
     * 创建一个工作簿
     */
    private void createWorkbook() {
        this.wb = new SXSSFWorkbook(500);
    }

    /**
     * 创建工作表
     *
     * @param sheetNo sheet数量
     * @param index   序号
     */
    private void createSheet(double sheetNo, int index) {
        this.sheet = wb.createSheet();
        // 设置工作表的名称.
        if (sheetNo == 0) {
            wb.setSheetName(index, sheetName);
        } else {
            wb.setSheetName(index, sheetName + index);
        }
    }

    /**
     * 对excel表单默认第一个索引名转换成list
     *
     * @param input 输入流
     * @return 转换后集合
     */
    public List<T> importExcel(InputStream input) throws Exception {
        return importExcel(org.apache.commons.lang3.StringUtils.EMPTY, input);
    }

    /**
     * 对excel表单指定表格索引名转换成list
     *
     * @param sheetName 表格索引名
     * @param input     输入流
     * @return 转换后集合
     */
    private List<T> importExcel(String sheetName, InputStream input) throws Exception {
        List<T> list = new ArrayList<T>();

        Workbook workbook = WorkbookFactory.create(input);
        Sheet sheet = null;
        if (StringUtils.isNotEmpty(sheetName)) {
            // 如果指定sheet名,则取指定sheet中的内容.
            sheet = workbook.getSheet(sheetName);
        } else {
            // 如果传入的sheet名不存在则默认指向第1个sheet.
            sheet = workbook.getSheetAt(0);
        }

        if (sheet == null) {
            throw new IOException("文件sheet不存在");
        }

        int rows = sheet.getPhysicalNumberOfRows();

        if (rows > 0) {
            // 默认序号
            int serialNum = 0;
            // 有数据时才处理 得到类的所有field.
            Field[] allFields = clazz.getDeclaredFields();
            // 定义一个map用于存放列的序号和field.
            Map<Integer, Field> fieldsMap = new HashMap<Integer, Field>(16);
            for (int col = 0; col < allFields.length; col++) {
                Field field = allFields[col];
                // 将有注解的field存放到map中.
                if (field.isAnnotationPresent(Excel.class)) {
                    // 设置类的私有字段属性可访问.
                    field.setAccessible(true);
                    fieldsMap.put(++serialNum, field);
                }
            }
            for (int i = 1; i < rows; i++) {
                // 从第2行开始取数据,默认第一行是表头.
                Row row = sheet.getRow(i);
                int cellNum = serialNum;
                T entity = null;
                for (int j = 0; j < cellNum; j++) {
                    Cell cell = row.getCell(j);
                    if (cell == null) {
                        continue;
                    } else {
                        // 先设置Cell的类型，然后就可以把纯数字作为String类型读进来了
                        row.getCell(j).setCellType(CellType.STRING);
                        cell = row.getCell(j);
                    }

                    String c = cell.getStringCellValue();
                    if (StringUtils.isEmpty(c)) {
                        continue;
                    }

                    // 如果不存在实例则新建.
                    entity = (entity == null ? clazz.newInstance() : entity);
                    // 从map中得到对应列的field.
                    Field field = fieldsMap.get(j + 1);
                    // 取得类型,并根据对象类型设置值.
                    Class<?> fieldType = field.getType();
                    if (String.class == fieldType) {
                        field.set(entity, String.valueOf(c));
                    } else if ((Integer.TYPE == fieldType) || (Integer.class == fieldType)) {
                        field.set(entity, Integer.parseInt(c));
                    } else if ((Long.TYPE == fieldType) || (Long.class == fieldType)) {
                        field.set(entity, Long.valueOf(c));
                    } else if ((Float.TYPE == fieldType) || (Float.class == fieldType)) {
                        field.set(entity, Float.valueOf(c));
                    } else if ((Short.TYPE == fieldType) || (Short.class == fieldType)) {
                        field.set(entity, Short.valueOf(c));
                    } else if ((Double.TYPE == fieldType) || (Double.class == fieldType)) {
                        field.set(entity, Double.valueOf(c));
                    } else if (Character.TYPE == fieldType) {
                        if ((c != null) && (c.length() > 0)) {
                            field.set(entity, Character.valueOf(c.charAt(0)));
                        }
                    } else if (Date.class == fieldType) {
                        if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            cell.setCellValue(sdf.format(cell.getNumericCellValue()));
                            c = sdf.format(cell.getNumericCellValue());
                        } else {
                            c = cell.getStringCellValue();
                        }
                    } else if (BigDecimal.class == fieldType) {
                        c = cell.getStringCellValue();
                    }
                }
                if (entity != null) {
                    list.add(entity);
                }
            }
        }

        return list;
    }

    /**
     * 对list数据源将其里面的数据导入到excel表单
     *
     * @return 结果
     * @throws Exception
     */
    public AgentJsonProtocol exportExcel() throws Exception {
        OutputStream out = null;
        try {
            // 取出一共有多少个sheet.
            double sheetNo = Math.ceil(list.size() / SHEETSIZE);
            for (int index = 0; index <= sheetNo; index++) {
                createSheet(sheetNo, index);
                Cell cell = null; // 产生单元格

                // 产生一行
                Row row = sheet.createRow(0);
                // 写入各个字段的列头名称
                for (int i = 0; i < fields.size(); i++) {
                    Field field = fields.get(i);
                    Excel attr = field.getAnnotation(Excel.class);
                    // 创建列
                    cell = row.createCell(i);
                    // 设置列中写入内容为String类型
                    cell.setCellType(CellType.STRING);
                    CellStyle cellStyle = wb.createCellStyle();
                    cellStyle.setAlignment(HorizontalAlignment.CENTER);
                    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                    if (attr.name().indexOf("注：") >= 0) {
                        Font font = wb.createFont();
                        font.setColor(HSSFFont.COLOR_RED);
                        cellStyle.setFont(font);
                        cellStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
                        sheet.setColumnWidth(i, 6000);
                    } else {
                        Font font = wb.createFont();
                        // 粗体显示
                        font.setBold(true);
                        // 选择需要用到的字体格式
                        cellStyle.setFont(font);
                        cellStyle.setFillForegroundColor(HSSFColorPredefined.LIGHT_YELLOW.getIndex());
                        // 设置列宽
                        sheet.setColumnWidth(i, (int) ((attr.width() + 0.72) * 256));
                        row.setHeight((short) (attr.height() * 20));
                    }
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);

                    // 写入列名
                    cell.setCellValue(attr.name());

                    // 如果设置了提示信息则鼠标放上去提示.
                    if (StringUtils.isNotEmpty(attr.prompt())) {
                        // 这里默认设了2-101列提示.
                        setXSSFPrompt(sheet, "", attr.prompt(), 1, 100, i, i);
                    }
                    // 如果设置了combo属性则本列只能选择不能输入
                    if (attr.combo().length > 0) {
                        // 这里默认设了2-101列只能选择不能输入.
                        setXSSFValidation(sheet, attr.combo(), 1, 100, i, i);
                    }
                }
                if (Excel.Type.EXPORT.equals(type)) {
                    fillExcelData(index, row, cell);
                }
            }
            String filename = encodingFilename(sheetName);
            out = new FileOutputStream(getAbsoluteFile(filename));
            wb.write(out);
            return new AgentJsonProtocol(AgentJsonProtocol.success().getCode(), filename);
        } catch (Exception e) {
//            log.error("导出Excel异常{}", e.getMessage());
            throw new Exception("导出Excel失败，请联系网站管理员！");
        } finally {
            if (wb != null) {
                try {
                    wb.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 填充excel数据
     *
     * @param index 序号
     * @param row   单元格行
     * @param cell  类型单元格
     */
    private void fillExcelData(int index, Row row, Cell cell) {
        int startNo = index * SHEETSIZE;
        int endNo = Math.min(startNo + SHEETSIZE, list.size());
        // 写入各条记录,每条记录对应excel表中的一行
        CellStyle cs = wb.createCellStyle();
        cs.setAlignment(HorizontalAlignment.CENTER);
        cs.setVerticalAlignment(VerticalAlignment.CENTER);
        for (int i = startNo; i < endNo; i++) {
            row = sheet.createRow(i + 1 - startNo);
            // 得到导出对象.
            T vo = (T) list.get(i);
            for (int j = 0; j < fields.size(); j++) {
                // 获得field.
                Field field = fields.get(j);
                // 设置实体类私有属性可访问
                field.setAccessible(true);
                Excel attr = field.getAnnotation(Excel.class);
                try {
                    // 设置行高
                    row.setHeight((short) (attr.height() * 20));
                    // 根据Excel中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
                    if (attr.isExport()) {
                        // 创建cell
                        cell = row.createCell(j);
                        cell.setCellStyle(cs);
                        if (vo == null) {
                            // 如果数据存在就填入,不存在填入空格.
                            cell.setCellValue("");
                            continue;
                        }

                        // 用于读取对象中的属性
                        Object value = getTargetValue(vo, field, attr);
                        String dateFormat = attr.dateFormat();
                        String readConverterExp = attr.readConverterExp();
                        if (StringUtils.isNotEmpty(dateFormat) && StringUtils.isNotNull(value)) {
                            cell.setCellValue(DateUtils.parseDateToStr(dateFormat, (Date) value));
                        } else if (StringUtils.isNotEmpty(readConverterExp) && StringUtils.isNotNull(value)) {
                            cell.setCellValue(convertByExp(String.valueOf(value), readConverterExp));
                        } else {
                            cell.setCellType(CellType.STRING);
                            // 如果数据存在就填入,不存在填入空格.
                            cell.setCellValue(StringUtils.isNull(value) ? attr.defaultValue() : value + attr.suffix());
                        }
                    }
                } catch (Exception e) {
//                    log.error("导出Excel失败{}", e);
                }
            }
        }
    }

    /**
     * 获取bean中的属性值
     *
     * @param vo    实体对象
     * @param field 字段
     * @param excel 注解
     * @return 最终的属性值
     * @throws Exception
     */
    private Object getTargetValue(T vo, Field field, Excel excel) throws Exception {
        Object o = field.get(vo);
        if (StringUtils.isNotEmpty(excel.targetAttr())) {
            String target = excel.targetAttr();
            if (target.indexOf(".") > -1) {
                String[] targets = target.split("[.]");
                for (String name : targets) {
                    o = getValue(o, name);
                }
            } else {
                o = getValue(o, target);
            }
        }
        return o;
    }

    /**
     * 以类的属性的get方法方法形式获取值
     *
     * @param o
     * @param name
     * @return value
     * @throws Exception
     */
    private Object getValue(Object o, String name) throws Exception {
        if (StringUtils.isNotEmpty(name)) {
            Class<?> clazz = o.getClass();
            String methodName = "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
            Method method = clazz.getMethod(methodName);
            o = method.invoke(o);
        }
        return o;
    }

    /**
     * 设置 POI XSSFSheet 单元格提示
     *
     * @param sheet         表单
     * @param promptTitle   提示标题
     * @param promptContent 提示内容
     * @param firstRow      开始行
     * @param endRow        结束行
     * @param firstCol      开始列
     * @param endCol        结束列
     */
    private void setXSSFPrompt(Sheet sheet, String promptTitle, String promptContent, int firstRow, int endRow,
                              int firstCol, int endCol) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        DataValidationConstraint constraint = helper.createCustomConstraint("DD1");
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        dataValidation.createPromptBox(promptTitle, promptContent);
        dataValidation.setShowPromptBox(true);
        sheet.addValidationData(dataValidation);
    }

    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     *
     * @param sheet    要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow   结束行
     * @param firstCol 开始列
     * @param endCol   结束列
     * @return 设置好的sheet.
     */
    private void setXSSFValidation(Sheet sheet, String[] textlist, int firstRow, int endRow, int firstCol, int endCol) {
        DataValidationHelper helper = sheet.getDataValidationHelper();
        // 加载下拉列表内容
        DataValidationConstraint constraint = helper.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        DataValidation dataValidation = helper.createValidation(constraint, regions);
        // 处理Excel兼容性问题
        if (dataValidation instanceof XSSFDataValidation) {
            dataValidation.setSuppressDropDownArrow(true);
            dataValidation.setShowErrorBox(true);
        } else {
            dataValidation.setSuppressDropDownArrow(false);
        }

        sheet.addValidationData(dataValidation);
    }

    /**
     * 解析导出值 0=男,1=女,2=未知
     *
     * @param propertyValue 参数值
     * @param converterExp  翻译注解
     * @return 解析后值
     * @throws Exception
     */
    private static String convertByExp(String propertyValue, String converterExp) throws Exception {
        try {
            String[] convertSource = converterExp.split(",");
            for (String item : convertSource) {
                String[] itemArray = item.split("=");
                if (itemArray[0].equals(propertyValue)) {
                    return itemArray[1];
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return propertyValue;
    }

    /**
     * 反向解析值 男=0,女=1,未知=2
     *
     * @param propertyValue 参数值
     * @param converterExp  翻译注解
     * @return 解析后值
     * @throws Exception
     */
    public static String reverseByExp(String propertyValue, String converterExp) throws Exception {
        try {
            String[] convertSource = converterExp.split(",");
            for (String item : convertSource) {
                String[] itemArray = item.split("=");
                if (itemArray[1].equals(propertyValue)) {
                    return itemArray[0];
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return propertyValue;
    }

    /**
     * 对list数据源将其里面的数据导入到excel表单
     *
     * @param list      导出数据集合
     * @param sheetName 工作表的名称
     * @return 结果
     */
    public AgentJsonProtocol exportExcel(List<T> list, String sheetName) {
        OutputStream out = null;
        HSSFWorkbook workbook = null;
        try {
            // 得到所有定义字段
            Field[] allFields = clazz.getDeclaredFields();
            List<Field> fields = new ArrayList<Field>();
            // 得到所有field并存放到一个list中.
            for (Field field : allFields) {
                if (field.isAnnotationPresent(Excel.class)) {
                    fields.add(field);
                }
            }

            // 产生工作薄对象
            workbook = new HSSFWorkbook();
            // excel2003中每个sheet中最多有65536行
            int SHEETSIZE = 65536;
            // 取出一共有多少个sheet.
            double sheetNo = Math.ceil(list.size() / SHEETSIZE);
            for (int index = 0; index <= sheetNo; index++) {
                // 产生工作表对象
                HSSFSheet sheet = workbook.createSheet();
                if (sheetNo == 0) {
                    workbook.setSheetName(index, sheetName);
                } else {
                    // 设置工作表的名称.
                    workbook.setSheetName(index, sheetName + index);
                }
                HSSFRow row;
                HSSFCell cell; // 产生单元格

                // 产生一行
                row = sheet.createRow(0);
                // 写入各个字段的列头名称
                for (int i = 0; i < fields.size(); i++) {
                    Field field = fields.get(i);
                    Excel attr = field.getAnnotation(Excel.class);
                    // 创建列
                    cell = row.createCell(i);
                    // 设置列中写入内容为String类型
                    cell.setCellType(CellType.STRING);
                    HSSFCellStyle cellStyle = workbook.createCellStyle();
                    cellStyle.setAlignment(HorizontalAlignment.CENTER);
                    cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
                    if (attr.name().indexOf("注：") >= 0) {
                        HSSFFont font = workbook.createFont();
                        font.setColor(HSSFFont.COLOR_RED);
                        cellStyle.setFont(font);
                        cellStyle.setFillForegroundColor(HSSFColorPredefined.YELLOW.getIndex());
                        sheet.setColumnWidth(i, 6000);
                    } else {
                        HSSFFont font = workbook.createFont();
                        // 粗体显示
                        font.setBold(true);
                        // 选择需要用到的字体格式
                        cellStyle.setFont(font);
                        cellStyle.setFillForegroundColor(HSSFColorPredefined.LIGHT_YELLOW.getIndex());
                        // 设置列宽
                        sheet.setColumnWidth(i, 3766);
                    }
                    cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                    cellStyle.setWrapText(true);
                    cell.setCellStyle(cellStyle);

                    // 写入列名
                    cell.setCellValue(attr.name());

                    // 如果设置了提示信息则鼠标放上去提示.
                    if (StringUtils.isNotEmpty(attr.prompt())) {
                        // 这里默认设了2-101列提示.
                        setHSSFPrompt(sheet, "", attr.prompt(), 1, 100, i, i);
                    }
                    // 如果设置了combo属性则本列只能选择不能输入
                    if (attr.combo().length > 0) {
                        // 这里默认设了2-101列只能选择不能输入.
                        setHSSFValidation(sheet, attr.combo(), 1, 100, i, i);
                    }
                }

                int startNo = index * SHEETSIZE;
                int endNo = Math.min(startNo + SHEETSIZE, list.size());
                // 写入各条记录,每条记录对应excel表中的一行
                HSSFCellStyle cs = workbook.createCellStyle();
                cs.setAlignment(HorizontalAlignment.CENTER);
                cs.setVerticalAlignment(VerticalAlignment.CENTER);
                for (int i = startNo; i < endNo; i++) {
                    row = sheet.createRow(i + 1 - startNo);
                    // 得到导出对象.
                    T vo = (T) list.get(i);
                    for (int j = 0; j < fields.size(); j++) {
                        // 获得field.
                        Field field = fields.get(j);
                        // 设置实体类私有属性可访问
                        field.setAccessible(true);
                        Excel attr = field.getAnnotation(Excel.class);
                        try {
                            // 根据Excel中设置情况决定是否导出,有些情况需要保持为空,希望用户填写这一列.
                            if (attr.isExport()) {
                                // 创建cell
                                cell = row.createCell(j);
                                cell.setCellStyle(cs);
                                try {
                                    if (String.valueOf(field.get(vo)).length() > 10) {
                                        throw new Exception("长度超过10位就不用转数字了");
                                    }
                                    cell.setCellType(CellType.STRING);
                                    if (vo == null) {
                                        // 如果数据存在就填入,不存在填入空格.
                                        cell.setCellValue("");
                                    } else {
                                        // 如果数据存在就填入,不存在填入空格.
                                        cell.setCellValue(field.get(vo) == null ? "" : String.valueOf(field.get(vo)));
                                    }

                                } catch (Exception e) {
                                    cell.setCellType(CellType.STRING);
                                    if (vo == null) {
                                        // 如果数据存在就填入,不存在填入空格.
                                        cell.setCellValue("");
                                    } else {
                                        // 如果数据存在就填入,不存在填入空格.
                                        cell.setCellValue(field.get(vo) == null ? "" : String.valueOf(field.get(vo)));
                                    }

                                }
                            }
                        } catch (Exception e) {
//                            log.error("导出Excel失败{}", e.getMessage());
                        }
                    }
                }
            }
            String filename = encodingFilename(sheetName);
            out = new FileOutputStream(getAbsoluteFile(filename));
            workbook.write(out);
            return new AgentJsonProtocol(AgentJsonProtocol.success().getCode(), filename);
        } catch (Exception e) {
//            log.error("导出Excel异常{}", e.getMessage());
            return new AgentJsonProtocol(AgentJsonProtocol.fail().getCode(), "导出Excel失败，请联系网站管理员！");
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 设置单元格上提示
     *
     * @param sheet         要设置的sheet.
     * @param promptTitle   标题
     * @param promptContent 内容
     * @param firstRow      开始行
     * @param endRow        结束行
     * @param firstCol      开始列
     * @param endCol        结束列
     * @return 设置好的sheet.
     */
    private static HSSFSheet setHSSFPrompt(HSSFSheet sheet, String promptTitle, String promptContent, int firstRow,
                                          int endRow, int firstCol, int endCol) {
        // 构造constraint对象
        DVConstraint constraint = DVConstraint.createCustomFormulaConstraint("DD1");
        // 四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation dataValidationView = new HSSFDataValidation(regions, constraint);
        dataValidationView.createPromptBox(promptTitle, promptContent);
        sheet.addValidationData(dataValidationView);
        return sheet;
    }

    /**
     * 设置某些列的值只能输入预制的数据,显示下拉框.
     *
     * @param sheet    要设置的sheet.
     * @param textlist 下拉框显示的内容
     * @param firstRow 开始行
     * @param endRow   结束行
     * @param firstCol 开始列
     * @param endCol   结束列
     * @return 设置好的sheet.
     */
    private static HSSFSheet setHSSFValidation(HSSFSheet sheet, String[] textlist, int firstRow, int endRow,
                                              int firstCol, int endCol) {
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textlist);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(firstRow, endRow, firstCol, endCol);
        // 数据有效性对象
        HSSFDataValidation dataValidationList = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(dataValidationList);
        return sheet;
    }

    /**
     * 编码文件名
     */
    private String encodingFilename(String filename) {
        filename = UUID.randomUUID().toString() + "_" + filename + ".xls";
        return filename;
    }

    /**
     * 获取下载路径
     *
     * @param filename 文件名称
     */
    private String getAbsoluteFile(String filename) {
        String downloadPath = "download/" + filename;
        File desc = new File(downloadPath);
        if (!desc.getParentFile().exists()) {
            desc.getParentFile().mkdirs();
        }
        return downloadPath;
    }
}