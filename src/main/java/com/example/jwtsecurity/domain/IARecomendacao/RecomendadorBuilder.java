package com.example.jwtsecurity.domain.IARecomendacao;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class RecomendadorBuilder implements RecommenderBuilder {
    public Recommender buildRecommender(DataModel model) throws TasteException {
        //ele irá se basear na similaridade entre os usuários para contruir recomendações.
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        //pega a maior similaridade (vizinhança) entre os usuários do nosso modelo
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
        //fazemos nossa recomendação baseada no usuário, que é retornada no recommender
        UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
        return recommender;
    }

}
