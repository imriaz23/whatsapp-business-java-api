package com.whatsapp.api.domain.messages;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.whatsapp.api.domain.messages.type.ComponentType;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Carousel component.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarouselComponent extends Component<CarouselComponent> {
    @JsonProperty("cards")
    private List<Card> cards;

    /**
     * Instantiates a new Carousel component.
     */
    public CarouselComponent() {
        super(ComponentType.CAROUSEL);
    }

    /**
     * Instantiates a new Carousel component.
     *
     * @param cards the cards
     */
    public CarouselComponent(List<Card> cards) {
        super(ComponentType.CAROUSEL);
        this.cards = cards;
    }

    /**
     * Gets cards.
     *
     * @return the cards
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * Sets cards.
     *
     * @param cards the cards
     * @return the carousel component
     */
    public CarouselComponent setCards(List<Card> cards) {
        this.cards = cards;
        return this;
    }

    /**
     * Add card carousel component.
     *
     * @param card the card
     * @return the carousel component
     */
    public CarouselComponent addCard(Card card) {
        if (this.cards == null) {
            this.cards = new ArrayList<>();
        }
        this.cards.add(card);
        return this;
    }
}