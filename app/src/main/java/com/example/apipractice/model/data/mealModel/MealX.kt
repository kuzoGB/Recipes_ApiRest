package com.example.apipractice.model.data.mealModel

import android.os.Parcel
import android.os.Parcelable
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class MealX(
    val dateModified: String?,
    val idMeal: String?,
    val strArea: String?,
    val strCategory: String?,
    val strCreativeCommonsConfirmed: String?,
    val strDrinkAlternate: String?,
    val strImageSource: String?,
    val strIngredient1: String?,
    val strIngredient10: String?,
    val strIngredient11: String?,
    val strIngredient12: String?,
    val strIngredient13: String?,
    val strIngredient14: String?,
    val strIngredient15: String?,
    val strIngredient16: String?,
    val strIngredient17: String?,
    val strIngredient18: String?,
    val strIngredient19: String?,
    val strIngredient2: String?,
    val strIngredient20: String?,
    val strIngredient3: String?,
    val strIngredient4: String?,
    val strIngredient5: String?,
    val strIngredient6: String?,
    val strIngredient7: String?,
    val strIngredient8: String?,
    val strIngredient9: String?,
    val strInstructions: String?,
    val strMeal: String?,
    val strMealThumb: String?,
    val strMeasure1: String?,
    val strMeasure10: String?,
    val strMeasure11: String?,
    val strMeasure12: String?,
    val strMeasure13: String?,
    val strMeasure14: String?,
    val strMeasure15: String?,
    val strMeasure16: String?,
    val strMeasure17: String?,
    val strMeasure18: String?,
    val strMeasure19: String?,
    val strMeasure2: String?,
    val strMeasure20: String?,
    val strMeasure3: String?,
    val strMeasure4: String?,
    val strMeasure5: String?,
    val strMeasure6: String?,
    val strMeasure7: String?,
    val strMeasure8: String?,
    val strMeasure9: String?,
    val strSource: String?,
    val strTags: String?,
    val strYoutube: String?,

    @Transient var ingredients: List<Ingredient>? = null
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
    )


    fun setIngredients() {
        ingredients = mutableListOf<Ingredient>().apply {
            if (strIngredient1!!.isNotBlank() && strMeasure1!!.isNotBlank()) add(
                Ingredient(
                    strIngredient1,
                    strMeasure1
                )
            )

            if (strIngredient2 != null && strMeasure2 != null)
                if (strIngredient2.isNotBlank() && strMeasure2.isNotBlank()) add(
                    Ingredient(
                        strIngredient2,
                        strMeasure2
                    )
                )

            if (strIngredient3 != null && strMeasure3 != null)
                if (strIngredient3.isNotBlank() && strMeasure3.isNotBlank()) add(
                    Ingredient(
                        strIngredient3,
                        strMeasure3
                    )
                )

            if (strIngredient4 != null && strMeasure4 != null)
                if (strIngredient4.isNotBlank() && strMeasure4.isNotBlank()) add(
                    Ingredient(
                        strIngredient4,
                        strMeasure4
                    )
                )

            if (strIngredient5 != null && strMeasure5 != null)
                if (strIngredient5.isNotBlank() && strMeasure5.isNotBlank()) add(
                    Ingredient(
                        strIngredient5,
                        strMeasure5
                    )
                )

            if (strIngredient6 != null && strMeasure6 != null)
                if (strIngredient6.isNotBlank() && strMeasure6.isNotBlank()) add(
                    Ingredient(
                        strIngredient6,
                        strMeasure6
                    )
                )

            if (strIngredient7 != null && strMeasure7 != null)
                if (strIngredient7.isNotBlank() && strMeasure7.isNotBlank()) add(
                    Ingredient(
                        strIngredient7,
                        strMeasure7
                    )
                )

            if (strIngredient8 != null && strMeasure8 != null)
                if (strIngredient8.isNotBlank() && strMeasure8.isNotBlank()) add(
                    Ingredient(
                        strIngredient8,
                        strMeasure8
                    )
                )

            if (strIngredient9 != null && strMeasure9 != null)
                if (strIngredient9.isNotBlank() && strMeasure9.isNotBlank()) add(
                    Ingredient(
                        strIngredient9,
                        strMeasure9
                    )
                )

            if (strIngredient10 != null && strMeasure10 != null)
                if (strIngredient10.isNotBlank() && strMeasure10.isNotBlank()) add(
                    Ingredient(
                        strIngredient10,
                        strMeasure10
                    )
                )

            if (strIngredient11 != null && strMeasure11 != null)
                if (strIngredient11.isNotBlank() && strMeasure11.isNotBlank()) add(
                    Ingredient(
                        strIngredient11,
                        strMeasure11
                    )
                )

            if (strIngredient12 != null && strMeasure12 != null)
                if (strIngredient12.isNotBlank() && strMeasure12.isNotBlank()) add(
                    Ingredient(
                        strIngredient12,
                        strMeasure12
                    )
                )

            if (strIngredient13 != null && strMeasure13 != null)
                if (strIngredient13.isNotBlank() && strMeasure13.isNotBlank()) add(
                    Ingredient(
                        strIngredient13,
                        strMeasure13
                    )
                )

            if (strIngredient14 != null && strMeasure14 != null)
                if (strIngredient14.isNotBlank() && strMeasure14.isNotBlank()) add(
                    Ingredient(
                        strIngredient14,
                        strMeasure14
                    )
                )

            if (strIngredient15 != null && strMeasure15 != null)
                if (strIngredient15.isNotBlank() && strMeasure15.isNotBlank()) add(
                    Ingredient(
                        strIngredient15,
                        strMeasure15
                    )
                )

            if (strIngredient16 != null && strMeasure16 != null) {
                if (strIngredient16.isNotBlank() && strMeasure16.isNotBlank()) add(
                    Ingredient(
                        strIngredient16,
                        strMeasure16
                    )
                )
            }

            if (strIngredient17 != null && strMeasure17 != null)
                if (strIngredient17.isNotBlank() && strMeasure17.isNotBlank()) add(
                    Ingredient(
                        strIngredient17,
                        strMeasure17
                    )
                )

            if (strIngredient18 != null && strMeasure18 != null)
                if (strIngredient18.isNotBlank() && strMeasure18.isNotBlank()) add(
                    Ingredient(
                        strIngredient18,
                        strMeasure18
                    )
                )

            if (strIngredient19 != null && strMeasure19 != null)
                if (strIngredient19.isNotBlank() && strMeasure19.isNotBlank()) add(
                    Ingredient(
                        strIngredient19,
                        strMeasure19
                    )
                )

            if (strIngredient20 != null && strMeasure20 != null)
                if (strIngredient20.isNotBlank() && strMeasure20.isNotBlank()) add(
                    Ingredient(
                        strIngredient20,
                        strMeasure20
                    )
                )
        }
    }


    data class Ingredient(val ingredientName: String, val ingredientMeasure: String)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dateModified)
        parcel.writeString(idMeal)
        parcel.writeString(strArea)
        parcel.writeString(strCategory)
        parcel.writeString(strCreativeCommonsConfirmed)
        parcel.writeString(strDrinkAlternate)
        parcel.writeString(strImageSource)
        parcel.writeString(strIngredient1)
        parcel.writeString(strIngredient10)
        parcel.writeString(strIngredient11)
        parcel.writeString(strIngredient12)
        parcel.writeString(strIngredient13)
        parcel.writeString(strIngredient14)
        parcel.writeString(strIngredient15)
        parcel.writeString(strIngredient16)
        parcel.writeString(strIngredient17)
        parcel.writeString(strIngredient18)
        parcel.writeString(strIngredient19)
        parcel.writeString(strIngredient2)
        parcel.writeString(strIngredient20)
        parcel.writeString(strIngredient3)
        parcel.writeString(strIngredient4)
        parcel.writeString(strIngredient5)
        parcel.writeString(strIngredient6)
        parcel.writeString(strIngredient7)
        parcel.writeString(strIngredient8)
        parcel.writeString(strIngredient9)
        parcel.writeString(strInstructions)
        parcel.writeString(strMeal)
        parcel.writeString(strMealThumb)
        parcel.writeString(strMeasure1)
        parcel.writeString(strMeasure10)
        parcel.writeString(strMeasure11)
        parcel.writeString(strMeasure12)
        parcel.writeString(strMeasure13)
        parcel.writeString(strMeasure14)
        parcel.writeString(strMeasure15)
        parcel.writeString(strMeasure16)
        parcel.writeString(strMeasure17)
        parcel.writeString(strMeasure18)
        parcel.writeString(strMeasure19)
        parcel.writeString(strMeasure2)
        parcel.writeString(strMeasure20)
        parcel.writeString(strMeasure3)
        parcel.writeString(strMeasure4)
        parcel.writeString(strMeasure5)
        parcel.writeString(strMeasure6)
        parcel.writeString(strMeasure7)
        parcel.writeString(strMeasure8)
        parcel.writeString(strMeasure9)
        parcel.writeString(strSource)
        parcel.writeString(strTags)
        parcel.writeString(strYoutube)
    }

    override fun describeContents(): Int {
        return 0
    }


    companion object CREATOR : Parcelable.Creator<MealX> {
        override fun createFromParcel(parcel: Parcel): MealX {
            return MealX(parcel)
        }

        override fun newArray(size: Int): Array<MealX?> {
            return arrayOfNulls(size)
        }
    }
}