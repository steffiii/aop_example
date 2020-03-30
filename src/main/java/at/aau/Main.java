package at.aau;

import at.aau.view.ConsoleView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ConsoleView.class);

        ConsoleView main = context.getBean(ConsoleView.class);
        main.waitForInput();

    }

}
