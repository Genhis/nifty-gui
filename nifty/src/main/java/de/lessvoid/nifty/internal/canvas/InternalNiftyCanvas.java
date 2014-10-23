package de.lessvoid.nifty.internal.canvas;

import java.util.ArrayList;
import java.util.List;

import de.lessvoid.nifty.api.NiftyColor;
import de.lessvoid.nifty.api.NiftyFont;
import de.lessvoid.nifty.api.NiftyImage;
import de.lessvoid.nifty.api.NiftyLineCapType;
import de.lessvoid.nifty.api.NiftyLineJoinType;
import de.lessvoid.nifty.api.NiftyLinearGradient;

public class InternalNiftyCanvas {
  private final List<Command> commands = new ArrayList<Command>();
  private boolean changed = true;

  public InternalNiftyCanvas() {
  }

  public void setFillColor(final NiftyColor color) {
    commands.add(new CommandFillColor(color));
    changed = true;
  }

  public void setFillLinearGradient(final NiftyLinearGradient gradient) {
    commands.add(new CommandFillLinearGradient(gradient));
    changed = true;
  }

  public void setStrokeColor(final NiftyColor color) {
    commands.add(new CommandStrokeStyle(color));
    changed = true;
  }

  public void setTextColor(final NiftyColor color) {
    commands.add(new CommandTextColor(color));
    changed = true;
  }

  public void setTextSize(final float textSize) {
    commands.add(new CommandTextSize(textSize));
    changed = true;
  }

  public void setLineWidth(final double lineWidth) {
    commands.add(new CommandLineWidth(lineWidth));
    changed = true;
  }

  public void setLineCap(final NiftyLineCapType lineCapType) {
    commands.add(new CommandLineCapType(lineCapType));
    changed = true;
  }

  public void setLineJoin(final NiftyLineJoinType lineJoinType) {
    commands.add(new CommandLineJoinType(lineJoinType));
    changed = true;
  }

  public void filledRect(final double x0, final double y0, final double x1, final double y1) {
    commands.add(new CommandFilledRect(x0, y0, x1, y1));
    changed = true;
  }

  public void text(final NiftyFont niftyFont, final int x, final int y, final String text) {
    commands.add(new CommandText(niftyFont, x, y, text));
    changed = true;
  }

  public void image(final int x, final int y, final NiftyImage image) {
    commands.add(new CommandImage(x, y, image));
    changed = true;
  }

  public void scale(final float scaleWidth, final float scaleHeight) {
    commands.add(new CommandScale(scaleWidth, scaleHeight));
    changed = true;
  }

  public void rotate(final float angleDegrees) {
    commands.add(new CommandRotate(angleDegrees));
    changed = true;
  }

  public void translate(final float x, final float y) {
    commands.add(new CommandTranslate(x, y));
    changed = true;
  }

  public void resetTransform() {
    commands.add(new CommandResetTransform());
    changed = true;
  }

  public void customerShader(final String shaderId) {
    commands.add(new CommandCustomShader(shaderId));
  }

  public void clear() {
  }

  public void beginPath() {
    commands.add(new CommandBeginPath());
    changed = true;
  }

  public void closePath() {
    commands.add(new CommandClosePath());
    changed = true;
  }

  public void moveTo(final float x, final float y) {
    commands.add(new CommandMoveTo(x, y));
    changed = true;
  }

  public void lineTo(final float x, final float y) {
    commands.add(new CommandLineTo(x, y));
    changed = true;
  }

  public void stroke() {
    commands.add(new CommandStroke());
    changed = true;
  }

  public void arc(final double x, final double y, final double r, final double startAngle, final double endAngle) {
    commands.add(new CommandArc(x, y, r, startAngle, endAngle));
    changed = true;
  }

  public boolean isChanged() {
    return changed;
  }

  public List<Command> getCommands() {
    changed = false;
    return new ArrayList<Command>(commands);
  }

  public void bezierCurveTo(final float cp1x, final float cp1y, final float cp2x, final float cp2y, final float x, final float y) {
    commands.add(new CommandBezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y));
    changed = true;
  }

  public void reset() {
    commands.clear();
    changed = true;
  }
}