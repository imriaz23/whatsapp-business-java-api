package com.whatsapp.api.examples;

import com.whatsapp.api.TestConstants;
import com.whatsapp.api.WhatsappApiFactory;
import com.whatsapp.api.domain.messages.*;
import com.whatsapp.api.domain.messages.type.ButtonSubType;
import com.whatsapp.api.domain.templates.type.LanguageType;
import com.whatsapp.api.impl.WhatsappBusinessCloudApi;

import static com.whatsapp.api.TestConstants.PHONE_NUMBER_1;
import static com.whatsapp.api.TestConstants.PHONE_NUMBER_ID;

/**
 * The type Send template carousel message example.
 */
public class SendTemplateCarouselMessageExample {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        WhatsappApiFactory factory = WhatsappApiFactory.newInstance(TestConstants.TOKEN);

        WhatsappBusinessCloudApi whatsappBusinessCloudApi = factory.newBusinessCloudApi();

        var message = Message.MessageBuilder.builder()//
                .setTo(PHONE_NUMBER_1)//
                .buildTemplateMessage(//
                        new TemplateMessage()//
                                .setName("carousel_template")//
                                .setLanguage(new Language(LanguageType.EN_US))//
                                // Body component with parameters
                                .addComponent(new BodyComponent()//
                                        .addParameter(new TextParameter("Variable 1"))//
                                        .addParameter(new TextParameter("Variable 2"))//
                                )//
                                // Carousel component
                                .addComponent(new CarouselComponent()//
                                        .addCard(new Card(0)//
                                                // Header with image
                                                .addComponent(new HeaderComponent()//
                                                        .addParameter(new ImageParameter()//
                                                                .setImage(new Image("header_image_id_1", null))//
                                                        )//
                                                )//
                                                // Body with parameters  
                                                .addComponent(new BodyComponent()//
                                                        .addParameter(new TextParameter("Card 1 Variable 1"))//
                                                        .addParameter(new TextParameter("Card 1 Variable 2"))//
                                                )//
                                                // Quick reply button
                                                .addComponent(new ButtonComponent(0, ButtonSubType.QUICK_REPLY)//
                                                        .addParameter(new ButtonPayloadParameter("quick_reply_payload_1"))//
                                                )//
                                                // URL button
                                                .addComponent(new ButtonComponent(1, ButtonSubType.URL)//
                                                        .addParameter(new TextParameter("url_variable_1"))//
                                                )//
                                        )//
                                        .addCard(new Card(1)//
                                                // Header with image
                                                .addComponent(new HeaderComponent()//
                                                        .addParameter(new ImageParameter()//
                                                                .setImage(new Image("header_image_id_2", null))//
                                                        )//
                                                )//
                                                // Body with parameters
                                                .addComponent(new BodyComponent()//
                                                        .addParameter(new TextParameter("Card 2 Variable 1"))//
                                                        .addParameter(new TextParameter("Card 2 Variable 2"))//
                                                )//
                                                // Quick reply button
                                                .addComponent(new ButtonComponent(0, ButtonSubType.QUICK_REPLY)//
                                                        .addParameter(new ButtonPayloadParameter("quick_reply_payload_2"))//
                                                )//
                                                // URL button
                                                .addComponent(new ButtonComponent(1, ButtonSubType.URL)//
                                                        .addParameter(new TextParameter("url_variable_2"))//
                                                )//
                                        )//
                                )//
                );

        whatsappBusinessCloudApi.sendMessage(PHONE_NUMBER_ID, message);
    }
}