package org.LLD.Entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.LLD.Enums.PlayerSymbol;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Players {
    private String playerName;
    private PlayerSymbol playerSymbol;
}
