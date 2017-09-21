// "Replace by 'invokeLater' call" "true"
import javax.swing.SwingUtilities

@ReplacementFor("SwingUtilities.invokeLater(this)", imports = arrayOf("javax.swing.SwingUtilities"))
fun Runnable.invokeItLater() {
    SwingUtilities.invokeLater(this)
}

@ReplacementFor("SwingUtilities.invokeLater(runnable)", imports = arrayOf("javax.swing.SwingUtilities"))
fun invokeLater(runnable: Runnable) {
    SwingUtilities.invokeLater(runnable)
}

fun foo() {
    <caret>SwingUtilities.invokeLater(Runnable {
        print(1)
    })
}