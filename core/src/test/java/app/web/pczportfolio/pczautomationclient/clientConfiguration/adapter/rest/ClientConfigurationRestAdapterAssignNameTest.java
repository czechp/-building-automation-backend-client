package app.web.pczportfolio.pczautomationclient.clientConfiguration.adapter.rest;

import app.web.pczportfolio.pczautomationclient.http.HttpRequestSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
class ClientConfigurationRestAdapterAssignNameTest {
    private static final String URL = "/api/configuration/name";

    @MockBean
    HttpRequestSender httpRequestSender;
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    void assignClientNewNameTest() throws Exception {
        //given
        final var newName = "Some new name";
        final var requestBuilder = MockMvcRequestBuilders.patch(URL)
                .param("name", newName);
        //when
        //then
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
