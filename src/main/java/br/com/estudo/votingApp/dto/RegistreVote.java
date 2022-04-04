package br.com.estudo.votingApp.dto;

import javax.validation.constraints.NotBlank;

public class RegistreVote {
    @NotBlank
    private String optionValue;

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }
}
