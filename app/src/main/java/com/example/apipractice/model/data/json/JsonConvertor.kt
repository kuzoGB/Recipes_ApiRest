import android.content.Context
import android.util.Log
import com.example.apipractice.model.data.mealModel.MealX
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File
import java.io.FileOutputStream

object JsonConvertor {
    private const val DIRECTORY_NAME = "recipes"
    private var selectedMeal: MealX? = null
    private const val JSON_EXTENSION = ".json"

    fun saveRecipe(context: Context, mealToSave: MealX, fileName: String) {
        val jsonString = Json.encodeToString(mealToSave)
        val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)
        directory.mkdirs()
        val file = File(directory, fileName + JSON_EXTENSION)

        try {
            val fileOutputStream = FileOutputStream(file)
            fileOutputStream.write(jsonString.toByteArray())
            fileOutputStream.close()
            Log.d("SaveRecipe", "Recipe saved successfully to $file")
        } catch (e: Exception) {
            Log.e("SaveRecipe", "Error saving recipe: ${e.message}")
        }
    }

    fun readRecipe(context: Context, fileName: String): MealX? {
        val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)

        val jsonContent = File(directory, fileName + JSON_EXTENSION).readText()
        val recipe = Json.decodeFromString<MealX>(jsonContent)

        Log.d("READ_JSON", "Recipe id: ${recipe.idMeal}")
        Log.d("READ_JSON", "Recipe name: ${recipe.strMeal}")

        selectedMeal = recipe
        return selectedMeal
    }

    fun getMealsList(context: Context): List<MealX> {
        val directory = File(context.getExternalFilesDir(null), DIRECTORY_NAME)

        val mealsList = mutableListOf<MealX>()
        Log.d("JSON_READ", "Total JSON: ${mealsList.count()}")

        directory.listFiles { file ->
            file.isFile && file.extension.equals("json", ignoreCase = true)
        }?.forEach { file ->
            try {
                val jsonContent = file.readText()
                val meal = Json.decodeFromString<MealX>(jsonContent)
                mealsList.add(meal)
                Log.d("JSON_READ", "JSON READED: ${file.name}")
            } catch (e: Exception) {
                Log.d("JSON", "Error reading JSON file: ${file.name}, ${e.message}")
                println("Error reading JSON file: ${file.name}, ${e.message}")
            }
        }

        return mealsList
    }


    fun getMealSelected(): MealX? {
        return selectedMeal
    }
}