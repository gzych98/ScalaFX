package hello

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.ChoiceDialog
import scalafx.scene.control._
import scalafx.event.ActionEvent
import scalafx.Includes._

object HelloWorld extends JFXApp {
  stage = new PrimaryStage {
    title = "C <-> F"
    scene = new Scene(260,250) {
      val label = new Label("Podaj wartość temperatury")
      label.layoutX = 20
      label.layoutY = 20

      val textField = new TextField
      textField.layoutX = 20
      textField.layoutY = 50 
      textField.promptText = "Wpisz temp."

      val label2 = new Label("Wybierz metodę konwersji")
      label2.layoutX = 20
      label2.layoutY = 90

      val comboBox = new ComboBox(List("C > F","F > C"))
      comboBox.layoutX = 20
      comboBox.layoutY = 120
      comboBox.promptText = "None"

      val button = new Button("Konwertuj!")
      button.layoutX=20
      button.layoutY=170

      val wynik = new Label("Rezultat konwersji: ...")
      wynik.layoutX = 20
      wynik.layoutY = 210

      
      

      content = List(button, comboBox, label, label2, textField, wynik)

      button.onAction = (e:ActionEvent) => {
        val selected = comboBox.selectionModel.apply.getSelectedItem()
        var temp = textField.getText.toDouble
        if (selected == "C > F") {
          temp = temp*1.8 +32
        } else if (selected == "F > C") {
          temp = (temp-32)/1.8
        } else {temp = 69}
        wynik.text = s"Rezultat konwersji: ... $temp"
      }
    }
  }
}