package com.movies.movies;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;

@Service
public class ReviewService {

    private static final Logger logger = LoggerFactory.getLogger(ReviewService.class);

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        if (imdbId == null || imdbId.isEmpty()) {
            throw new IllegalArgumentException("IMDB ID cannot be null or empty");
        }

        Review review = new Review(reviewBody);
        review = reviewRepository.save(review);

        logger.info("Review ID: {}", review.getId());
        logger.info("IMDB ID: {}", imdbId);

        UpdateResult result = mongoTemplate.updateFirst(
                Query.query(Criteria.where("imdbId").is(imdbId)),
                Update.update("reviewIds", Arrays.asList(review.getId())),
                Movie.class
        );

        logger.info("Update result: {}", result);

        return review;
    }
}


