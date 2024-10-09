package services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

@Service
public class FluxLearningService {

    //    creating flux
    public Flux<String> getFlux(){
        Flux<String> nameFlux = Flux.just("Ankit", "Varun", "Raghav", "Shubh", "Rohit");
        return  nameFlux;
    }

    public Flux<String> fruitFlux(){
        List<String> fruitNames = List.of("mango", "apple", "orange");
        return Flux.fromIterable(fruitNames);
    }

    ///  --------------map()--------------------------
    public Flux<String> mapExample() {
        Flux<String> capFlux = getFlux().map(name -> name.toUpperCase()).log();
        return capFlux;
    }

    //-------------------filter()-------------------------
    public Flux<String> filterExample(){
        return  getFlux().filter(name->name.length()>4).log();
    }

    // ----------------flatmap()---------------------
    public Flux<String> flatMapEx(){
        return getFlux().flatMap(name->Flux.just(name.split(""))).delayElements(Duration.ofSeconds(2)).log();

    }

    // -----------transform example-------------
    public Flux transformExample(){
        Function<Flux<String>, Flux<String>> funInterace= (name)->name.map(String::toUpperCase);

        return getFlux().transform(funInterace).log();
    }


    // --------- defaultIfEmpty()---------------------------------------
    public Flux<String> ifExample(int length){
        return getFlux().filter(name->name.length()>length).defaultIfEmpty("The Flux is Empty").log();
    }

    //------------------------ concat(static) / concatWith(instance)----------------------------
    public Flux<String> concatExample(){
        return  Flux.concat(getFlux(), fruitFlux());
    }

    // -----------------zip()----zipWith()------------------------
    public Flux<Tuple2<String, Integer>> zipExample(){
        return Flux.zip(getFlux(), Flux.just(12,12,2,2,4));
    }

    public Flux<String> sideEffect(){
        return  getFlux().doOnNext(data->{
                    System.out.println(data+" on next ");
                }).doOnSubscribe(data->{
                    System.out.println(data +" do On Subscribe");
                })
                .doOnEach(data->{
                    System.out.println(data+" on each");
                })
                .doOnComplete(()->{
                    System.out.println("Completed.....");
                });
    }

}

