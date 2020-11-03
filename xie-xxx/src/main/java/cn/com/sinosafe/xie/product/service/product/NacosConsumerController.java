package cn.com.sinosafe.xie.product.service.product;

/**
 * Created by xiehanchun on 2020/10/15
 */
//@RestController
//public class NacosConsumerController {
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @GetMapping(value = "/test/app/name")
//    public String test() {
//        //使用 LoadBalanceClient 和 RestTemplate 结合的方式来访问
//        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
//        String url = String.format("http://%s:%s/test/%s", serviceInstance.getHost(), serviceInstance.getPort(), appName);
//        return restTemplate.getForObject(url, String.class);
//    }
//}
