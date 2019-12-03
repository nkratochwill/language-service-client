package controller

import com.google.gson.GsonBuilder
import data.Json
import javafx.application.Application
import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.TextArea
import javafx.stage.Stage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.net.URLEncoder


fun main() {
    Application.launch(Controller::class.java)
}

/**
 * Initializes the gui and binds the gui elements to the fxml file
 */
class Controller : Application() {
    lateinit var input: TextArea
    lateinit var output: TextArea
    private val gson = GsonBuilder().setPrettyPrinting().create()
    private val scope = CoroutineScope(Dispatchers.Default)

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val root: Parent = FXMLLoader.load(javaClass.getResource("/view.fxml"))
        primaryStage.title = "My Language Tool"
        primaryStage.scene = Scene(root, 600.0, 350.0)
        primaryStage.show()
    }

    @FXML
    fun initialize() {
    }

    fun check() {
        var json: Json
        val encodedText = URLEncoder.encode(input.text, "UTF-8")
        scope.launch {
            json = withContext(Dispatchers.IO) {
                gson.fromJson(URL("http://localhost:8080/langcheck?text=$encodedText").readText(), Json::class.java)
            }
            val formattedText = """
                reliable : ${json.reliable}
                language : ${json.language}
                short : ${json.short}
                probability : ${json.probability}
            """.trimIndent()
            output.text = formattedText
        }
    }

    fun exit() {
        val stage = input.scene.window as Stage
        stage.close()
    }


    /**
     * Clears all input and output fields
     */
    fun reset() {
        input.clear()
        output.clear()
    }
}

