import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> list) {
        Logger logger = Logger.getInstance();
        List<Integer> res = new ArrayList<>();

        logger.log("Запускаем фильтрацию");

        for (int i : list) {
            if (i < treshold) logger.log("Элемент \"" + i + "\" не проходит");
            else {
                res.add(i);
                logger.log("Элемент \"" + i + "\" проходит");
            }
        }
        return res;
    }
}
