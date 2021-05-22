package pl.miloszlewandowski.dietly_api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Initialization {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }
}
