package com.example.jwtsecurity.domain.IARecomendacao;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class RecomendadorServer {

    // ESSA CLASSE NÃO É UMA CLASSE DE CONTROLER E SIM UMA CLASS DE SERVIÇO

    @GetMapping("/recomendador")
    public List<RecommendedItem> recomendador() throws IOException, TasteException {

        DataModel eventos = new Recomendador().getModeloEventos();
        Recommender recommender = new RecomendadorBuilder().buildRecommender(eventos);

        /*
        * List<RecommendedItem> recommendations = recommender.recommend(4, 3);
        for (RecommendedItem recommendation : recommendations) {
            System.out.println("Voce pode gostar deste evento");
            System.out.println(recommendation);
        }
        * */

        return recommender.recommend(4, 10);
    }
}
