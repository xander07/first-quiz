package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {

    private int balance = 0;
    private Map<String, Drink> drinks = new HashMap<>();

    public static VendingMachine getInstance() {
        return new VendingMachineImpl();
    }

    public VendingMachineImpl() {
        // Agregar las bebidas disponibles en el vending machine
        drinks.put("ScottCola", new DrinkImpl("ScottCola", true));
        drinks.put("KarenTea", new DrinkImpl("KarenTea", false));
    }

    @Override
    public void insertQuarter() {
        balance += 25;
    }

    @Override
    public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {
        Drink drink = drinks.get(name);

        if (drink == null) {
            throw new UnknownDrinkException();
        }

        if(drink.getName() == "ScottCola"){

          if (balance >= 75) {
            balance -= 75;
            return drink;
          } else {
            throw new NotEnoughMoneyException();
          }
        }

        else if (drink.getName() == "KarenTea"){

          if (balance >= 100) {
            balance -= 100;
            return drink;
          } else {
            throw new NotEnoughMoneyException();
          }
        }

        else{
          throw new UnknownDrinkException();
        }
    }
}
