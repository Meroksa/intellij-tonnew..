// This is a generated file. Not intended for manual editing.
package com.github.andreypfau.intellijton.func.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface FuncIfStatement extends PsiElement {

  @NotNull
  List<FuncBlock> getBlockList();

  @Nullable
  FuncExpression getExpression();

}
