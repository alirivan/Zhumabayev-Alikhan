import data.interfaces.IDB;
import org.glassfish.jersey.internal.inject.AbstractBinder;
import postgres.PostgresDB;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;

public class MyApplicationBinder extends AbstractBinder {

    @Override
    protected void configure() {
        bind(PostgresDB.class).to(IDB.class);
        bind(UserRepository.class).to(IUserRepository.class);
    }
}
