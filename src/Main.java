import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        for(var c:ParseExpressions(get(new int[]{1,2,3,4,5,6,7,8}))){
            if(Double.parseDouble((engine.eval(c)).toString()) == 100.0)
                System.out.println(c);
        }
    }
    public static String[] ParseExpressions(String strArray){
        return strArray.split(" ");
    }
    public static String get(int[] array) {
        List<String> operators = List.of("+", "-", "/", "*", "");
        String result = "";
        for (int v = 0; v < Math.pow(5, array.length - 1); v++) {
            int j = v;
            for (int i = 0; i < array.length - 1; i++) {
                result += array[i] + operators.get(j % 5);
                j /= 4;
            }
            result += array[array.length - 1] + " ";
        }
        return result;
    }
}
