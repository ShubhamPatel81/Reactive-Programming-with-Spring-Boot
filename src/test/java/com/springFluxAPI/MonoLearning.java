package com.springFluxAPI;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@SpringBootTest
class MonoLearning {

    @Test
    public void test() throws InterruptedException {
        System.out.println("Test Started");

//		// Creating a Mono publisher that emits a single value
//		Mono<String> monoPublisher = Mono.just("");  // Corrected Mono syntax
//		monoPublisher.subscribe(new CoreSubscriber<String>() {
//			@Override
//			public void onSubscribe(Subscription s) {
//
//				System.out.println("Subscription Done");
//			s.request(1);
//
//			}
//
//			@Override
//			public void onNext(String s) {
//				System.out.println("Data: "+s);
//			}
//
//			@Override
//			public void onError(Throwable t) {
//				System.out.println("error: "+ t);
//			 }
//
//			@Override
//			public void onComplete() {
//				System.out.println("Completed");
//			}
//		});


//		//Using error MONO and .just() and .then() methid
//		Mono<Object> errorMono=  Mono.error(new RuntimeException("Error mono!!!"));
//		Mono<Object> m1 = Mono
//				.just("Helo, This is the main mono")
//				.log()
//				.then(errorMono)
//
//				;
//		m1.subscribe(data->{
//			System.out.println("Data is : "+data);
//		});
//		errorMono.subscribe(System.out::println);

        System.out.println("---------------------------Mono-----------------------------------------------");
        //zip() and withZip() method
        Mono<String> m1 = Mono.just("This m1 is zip() and withZip() method");
        Mono<String> m2 = Mono.just("This is m2 for zip() and withZip()  method ");
        Mono<Integer> m3 = Mono.just(23232232);

//		System.out.println("----------------------------zip()----------------------------------------------------------");
//		Mono<Tuple3<String, String, Integer>> combine3Mono = Mono.zip(m1, m2, m3);
//		Mono<Tuple2<String , String>> combineMono=  Mono.zip(m1, m2);
//		combine3Mono.subscribe(data->{
//			System.out.println(data.getT1());
//			System.out.println(data.getT2());
//			System.out.println(data.getT3());
//			System.out.println(data);
//		});
//		System.out.println("----------------------zipWithMono()------------------------------------------------------");
//		Mono<Tuple2<String, String>> zipWithMono = m1.zipWith(m2);
//		zipWithMono.subscribe(data->{
//			System.out.println(zipWithMono);
//		});

	/*	System.out.println("------------------------map()-----------------------------------------------------------");
		//Map() and flatMap()
		Mono<String> map = m1.map(value -> value.toUpperCase());
		  map.subscribe(System.out::println);


		System.out.println("------------------------flatMap()--------------------------------------------------------");
		Mono<String[]> resultFlatMap = m1.flatMap(valueM1 -> Mono.just(valueM1.split(" ")));
		resultFlatMap.subscribe(data->{
			for (String s : data){
				System.out.println(s);
			}
		});
		System.out.println("---------------------------------flatMapMany()-----------Flux---------------------------");
		//It will publish the data like flix
		Flux<String> stringFlux = m1.flatMapMany(valueM1 -> Flux.just(valueM1.split("")));
		stringFlux.subscribe(data->{
			System.out.println(data);
		});
*/

        System.out.println("----------concatWith()---------------------------------------------");
        Flux<String> stringFlux = m1.concatWith(m2)
                .delayElements(Duration.ofMillis(2000));
        stringFlux.subscribe(System.out::println);

        Thread.sleep(3000);
    }


    // Flux represents multiple values (0 to many), but not demonstrated here
}
