package jm.rbs.customer.account.controller;

import jm.rbs.customer.account.model.AccountService;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getBalanceTestWithExistingValue() throws Exception {
        this.mockMvc.perform(get("/account/getBalance/100"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("1500")));

    }

    @Test
    public void depositAmountTest() throws Exception {
        this.mockMvc.perform(get("/account/deposit/100/1000"))
                .andExpect(status().isOk());
    }

    @Test
    public void withdrawAmountTest() throws Exception {
        this.mockMvc.perform(get("/account/withdrawAmount/100/1000"))
                .andExpect(status().isOk());
    }

}