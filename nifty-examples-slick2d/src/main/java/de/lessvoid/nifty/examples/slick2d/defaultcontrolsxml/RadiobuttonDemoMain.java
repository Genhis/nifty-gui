package de.lessvoid.nifty.examples.slick2d.defaultcontrolsxml;

import de.lessvoid.nifty.examples.defaultcontrolsxml.RadiobuttonExample;
import de.lessvoid.nifty.examples.slick2d.SlickExampleLoader;

/**
 * Demo class to execute the default controls XML &quot;Radiobutton&quot; demonstration.
 *
 * @author Martin Karing &lt;nitram@illarion.org&gt;
 */
public class RadiobuttonDemoMain {
  /**
   * Execute the demonstration.
   *
   * @param args call arguments - have no effect
   */
  public static void main(final String[] args) {
    SlickExampleLoader.createGame(new SlickExampleLoader(new RadiobuttonExample()));
  }
}
