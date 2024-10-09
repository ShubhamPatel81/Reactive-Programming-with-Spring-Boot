package com.springFluxAPI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

@SpringBootTest
public class FluxLearning {

    //    @Test
//    void testing(){
//        System.out.println("This is testing");
//    }
    @Autowired
    private services.FluxLearningService fluxLearnService;
    @Test
    public  void simplefluxText(){
//    fluxLearnService.getFlux().subscribe(data ->{
//        System.out.println(data);
//        System.out.println("Done with flux data");
//    });


        fluxLearnService.fruitFlux().subscribe(System.out::println);
    }
    @Test
    public void  mapTest(){
//    fluxLearnService.mapExample().subscribe(data->{
//        System.out.println(data);
//    });
        Flux<String> capFlux =fluxLearnService.mapExample();
        StepVerifier.create(capFlux)
                .expectNextCount(5)
                .verifyComplete();
    }
    @Test
    public void filterTest(){
        Flux<String> filterFlux=  fluxLearnService.filterExample();
        StepVerifier.create(filterFlux)
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    public void  flatMapExample(){
        Flux<String> stringFlux= fluxLearnService.flatMapEx();
        StepVerifier.create(stringFlux)
                .expectNextCount(26)
                .verifyComplete();
    }

    @Test
    public void transformFlux(){
        Flux flux = fluxLearnService.transformExample();
        StepVerifier.create(flux)
                .expectNextCount(4)
                .verifyComplete();
    }
    @Test
    public void ifExample(){
        Flux<String>  getFlux= fluxLearnService.ifExample(8);
        StepVerifier.create(getFlux)
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void concatExample(){
        Flux<String> stringFlux=fluxLearnService.concatExample();
        StepVerifier.create(stringFlux)
                .expectNextCount(4)
                .verifyComplete();
    }

    @Test
    void zipExample(){
        Flux< Tuple2<String, Integer>> tuple2Flux =fluxLearnService.zipExample().log();
        StepVerifier.create(tuple2Flux)
                .expectNextCount(5)
                .verifyComplete();
    }
    @Test
    void sideEffect(){
        fluxLearnService.sideEffect().subscribe(System.out::println);
    }

}
