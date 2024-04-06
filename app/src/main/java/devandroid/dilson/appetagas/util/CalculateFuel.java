package devandroid.dilson.appetagas.util;

import devandroid.dilson.appetagas.model.Ethanol;
import devandroid.dilson.appetagas.model.Gasoline;

public class CalculateFuel {

    public static String getResult(Gasoline gasoline, Ethanol ethanol){
        final Double IDEAL_PRICE = gasoline.getPrice() * 0.7;

        if (ethanol.getPrice() <= IDEAL_PRICE)
           return "Abastecer com Etanol";

        return "Abastecer com Gasolina";

    }
}
