package seminars.fourth.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WebServiceTest {

    String reply = "\n" +
            "<!doctype html>\n" +
            "<html dir=\"ltr\" lang=\"ru\"\n" +
            "    chrome-refresh-2023>\n" +
            "  <head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <title>Новая вкладка</title>\n" +
            "    <style>\n" +
            "      body {\n" +
            "        background: #374E69;\n" +
            "        margin: 0;\n" +
            "      }\n" +
            "\n" +
            "      #backgroundImage {\n" +
            "        border: none;\n" +
            "        height: 100%;\n" +
            "        pointer-events: none;\n" +
            "        position: fixed;\n" +
            "        top: 0;\n" +
            "        visibility: hidden;\n" +
            "        width: 100%;\n" +
            "      }\n" +
            "\n" +
            "      [show-background-image] #backgroundImage {\n" +
            "        visibility: visible;\n" +
            "      }\n" +
            "    </style>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "    <iframe id=\"backgroundImage\" src=\"chrome-untrusted://new-tab-page/custom_background_image?url=https%3A%2F%2Flh5.googleusercontent.com%2Fproxy%2F7VWzzKIjauGcVkrcveLxl_TQm7eAaaFa9b0Fj-dVvWoZ2x2X0YIcus_LdNFPB8ggANvfwDKI4t4F9W12uUC3anzK9XoqSI8NS3xWdw%3Dw3840-h2160-p-k-no-nd-mv\"></iframe>\n" +
            "    <ntp-app></ntp-app>\n" +
            "    <script type=\"module\" src=\"new_tab_page.js\"></script>\n" +
            "    <link rel=\"stylesheet\" href=\"chrome://resources/css/text_defaults_md.css\">\n" +
            "    <link rel=\"stylesheet\" href=\"chrome://theme/colors.css?sets=ui,chrome\">\n" +
            "    <link rel=\"stylesheet\" href=\"shared_vars.css\">\n" +
            "  </body>\n" +
            "</html>\n";

    @Test
    void httpRequest() {
        HttpClient mockHttpClient = mock(HttpClient.class);
        when(mockHttpClient.get(anyString())).thenReturn(reply);

        WebService webService = new WebService(mockHttpClient);
        String result = webService.httpRequest("1234");
        assertEquals(reply, result);
    }
}