package com.github.lambdamix.elambda.psi;

import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FindUtil {
    public static List<Variable> findTopLevelVariables(PsiFile psiFile) {
        if (psiFile instanceof ELambdaFile) {
            return PsiTreeUtil.getChildrenOfTypeAsList(psiFile, Binding.class).stream()
                    .map(Binding::getVariable).collect(Collectors.toList());
        } else {
            return Collections.emptyList();
        }
    }

    public static List<Variable> findTopLevelVariables(PsiFile psiFile, String name) {
        return findTopLevelVariables(psiFile).stream()
                .filter(v -> name.equals(v.getLid().getText())).collect(Collectors.toList());
    }

    public static List<TypeDefinition> findTypeDefinitions(PsiFile psiFile) {
        if (psiFile instanceof ELambdaFile) return PsiTreeUtil.getChildrenOfTypeAsList(psiFile, TypeDefinition.class);
        else return Collections.emptyList();
    }

    public static List<TypeDefinition> findTypeDefinitions(PsiFile psiFile, String name) {
        return findTypeDefinitions(psiFile).stream().filter(def -> name.equals(def.getName())).collect(Collectors.toList());
    }
}
