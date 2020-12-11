package com.github.lambdamix.elambda.psi.reference;

import com.github.lambdamix.elambda.psi.TypeDefinition;
import com.github.lambdamix.elambda.psi.TypeVariable;
import com.github.lambdamix.elambda.psi.TypeVariableDef;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReferenceBase;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.PairProcessor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TypeVariableReference extends PsiReferenceBase<TypeVariable> {
    public TypeVariableReference(@NotNull TypeVariable element) {
        super(element, element.getLid().getTextRangeInParent());
    }

    private List<TypeVariableDef> multiResolve() {
        Processor processor = new Processor(myElement.getName());
        PsiTreeUtil.treeWalkUp(myElement, myElement.getContainingFile(), processor);
        return processor.typeVariableDefs;
    }

    @Override
    public @Nullable TypeVariableDef resolve() {
        List<TypeVariableDef> variableDefs = multiResolve();
        if (variableDefs.size() == 1) {
            return variableDefs.get(0);
        }
        return null;
    }

    private static class Processor implements PairProcessor<PsiElement, PsiElement> {
        final String name;
        List<TypeVariableDef> typeVariableDefs = Collections.emptyList();

        Processor(String name) {
            this.name = name;
        }

        @Override
        public boolean process(PsiElement scope, PsiElement prev) {
            if (scope instanceof TypeDefinition) {
                TypeDefinition typeDefinition = (TypeDefinition) scope;
                List<TypeVariableDef> vars = typeDefinition.getTypeVariableDefList();
                typeVariableDefs = vars.stream().filter(v -> name.equals(v.getName())).collect(Collectors.toList());
                return false;
            }
            return true;
        }
    }
}
