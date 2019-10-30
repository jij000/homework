package edu.mum.cs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PairValue {
    int sum;
    Long cnt;

    @Override
    public String toString() {
        return "[ " + String.valueOf(sum) + ", " + String.valueOf(cnt) + " ]";
    }

}