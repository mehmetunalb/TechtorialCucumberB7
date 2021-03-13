package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class DataTableSteps {

    @Given("the user print product titles")
    public void the_user_print_product_titles(DataTable dataTable) {
        List<String> productInfo= dataTable.asList();
        for (String info: productInfo) {
            System.out.println(info);
        }
    }
    @Then("user print credentials")
    public void user_print_credentials(io.cucumber.datatable.DataTable dataTable) {
        Map<String,String> credentials=dataTable.asMap(String.class,String.class);
        for (String key: credentials.keySet()) {
            System.out.println("Key: "+key+" Value: "+credentials.get(key));
        }
    }
    @Then("the user print product info")
    public void the_user_print_product_info(List<List<String>> products) {
        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.get(0).size(); j++) {
                System.out.print("| "+products.get(i).get(j)+" ");
            }
            System.out.print("|");
            System.out.println();
        }
    }

}
