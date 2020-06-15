package mastermind

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CodeCheckerTest{
    val codeChecker = CodeChecker();
    @Test
    fun noLettersCorrectThenCheckReturnsCeroAndCero(){
        val secretCode = "aabb"
        val guessCode = "jsje"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(0 to 0)
    }
    @Test
    fun whenTwoLettersMatchesInIncorrectPlaceReturnsTwoAndCero(){
        val secretCode = "aabb"
        val guessCode = "bsja"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(2 to 0)

    }
    @Test
    fun whenTwoLettersMatchesOneInCorrectPlaceReturnsTwoAndOne(){
        val secretCode = "aabb"
        val guessCode = "basj"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(2 to 1)

    }
    @Test
    fun whenThreeLettersMatchesTwoInCorrectPlaceReturnsTwoAndOne(){
        val secretCode = "adbb"
        val guessCode = "babj"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(3 to 1)
    }
    @Test
    fun whenAllMatchesThenReturnsFourAndFour(){
        val secretCode = "adbb"
        val guessCode = "adbb"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(4 to 4)
    }
    @Test
    fun whenThreeMatchesThenReturnsThreeAndThree(){
        val secretCode = "adbb"
        val guessCode = "adbc"

        Assertions.assertThat( codeChecker.correctLetters(secretCode, guessCode)).isEqualTo(3 to 3)
    }
}

fun CodeChecker.correctLetters(secretCode: String, guessCode: String): Pair<Int, Int>{
    val secrectCodeList = secretCode.toMutableList()
    var correctLetters = 0
    var correctPositions = 0

    for ((i,char) in guessCode.withIndex()){
        if(secrectCodeList.contains(char)){
            correctLetters ++
            secrectCodeList.remove(char)
        for((j,other) in secretCode.withIndex()){
            if(char == other){

                if(i == j) correctPositions ++
            }
        }
        }
    }

    return correctLetters to correctPositions
}