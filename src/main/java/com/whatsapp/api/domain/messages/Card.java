package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Card for carousel components.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {
    @JsonProperty("card_index")
    private int cardIndex;

    @JsonProperty("components")
    private List<Component<?>> components;

    /**
     * Instantiates a new Card.
     */
    public Card() {
    }

    /**
     * Instantiates a new Card.
     *
     * @param cardIndex the card index
     */
    public Card(int cardIndex) {
        this.cardIndex = cardIndex;
    }

    /**
     * Gets card index.
     *
     * @return the card index
     */
    public int getCardIndex() {
        return cardIndex;
    }

    /**
     * Sets card index.
     *
     * @param cardIndex the card index
     * @return the card
     */
    public Card setCardIndex(int cardIndex) {
        this.cardIndex = cardIndex;
        return this;
    }

    /**
     * Gets components.
     *
     * @return the components
     */
    public List<Component<?>> getComponents() {
        return components;
    }

    /**
     * Sets components.
     *
     * @param components the components
     * @return the card
     */
    public Card setComponents(List<Component<?>> components) {
        this.components = components;
        return this;
    }

    /**
     * Add component card.
     *
     * @param component the component
     * @return the card
     */
    public Card addComponent(Component<?> component) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(component);
        return this;
    }
}