package Lecture12;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.herokuapp.NavigationItems;
import pageObjects.herokuapp.NavigationPage;
import pageObjects.herokuapp.SortableDataTablesPage;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lecture12_2Test extends BaseTest {

    @Test(priority = 2)
    public void sortCurrency_Test() {
        get(NavigationPage.class).open().navigateTo(NavigationItems.SORTABLE_DATA_TABLES);
        Map<String, List<String>> mapTableData = get(SortableDataTablesPage.class).checkTableIsDisplayed().clickTableColumn("Due").getTableData();
        List<Double> currencyData = mapTableData.get("Due").stream().map(currency -> Double.parseDouble(currency.replace("$", ""))).collect(Collectors.toList());
        List<Double> sortedData = currencyData;
        Collections.sort(sortedData);
        Assert.assertEquals(currencyData, sortedData);
    }
}