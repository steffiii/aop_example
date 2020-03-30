package at.aau.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import at.aau.presenter.UIPresenter;

import java.util.Scanner;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "at.aau")
public class ConsoleView {

    @Autowired
    UIPresenter uip;

    public void waitForInput() {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input = sc.nextLine();

            System.out.println(uip.handleInput(input));

        }


    }

}
