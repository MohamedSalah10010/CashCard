package com.learn.cashcard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
//import org.springframework.boot.test.json.JsonbTester;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
@JsonTest
public class CashCardJsonTest  {

    @Autowired
    private JacksonTester<CashCard> json;

    @Test
     void myFirstTest() {
     assertThat(42).isEqualTo(42);
    }

    @Test
    void cashCardSerializtion() throws IOException {
        CashCard card = new CashCard(99L, 123.45);

        assertThat(json.write(card)).isStrictlyEqualToJson("/expected.json");
        assertThat(json.write(card)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(card)).extractingJsonPathNumberValue("@.id").isEqualTo(99);
        assertThat(json.write(card)).hasJsonPathNumberValue("@.amount");
        assertThat(json.write(card)).extractingJsonPathNumberValue("@.amount").isEqualTo(123.45);

    }
}
