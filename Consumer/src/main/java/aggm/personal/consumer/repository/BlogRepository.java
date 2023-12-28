package aggm.personal.consumer.repository;

import aggm.personal.consumer.domain.Blog;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<Blog, ObjectId> {

}
