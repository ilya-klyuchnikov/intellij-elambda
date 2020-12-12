package com.github.lambdamix.elambda;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

public class ELambdaCommenter implements Commenter {
    @Override
    public String getLineCommentPrefix() {
        return "--";
    }

    @Override
    @Nullable
    public String getBlockCommentPrefix() {
        return null;
    }

    @Override
    @Nullable
    public String getBlockCommentSuffix() {
        return null;
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}
