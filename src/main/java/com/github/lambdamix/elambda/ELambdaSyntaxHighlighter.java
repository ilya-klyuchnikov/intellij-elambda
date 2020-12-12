package com.github.lambdamix.elambda;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class ELambdaSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey SEPARATOR =
            createTextAttributesKey("ELAMBDA_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey KEYWORD =
            createTextAttributesKey("ELAMBDA_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("ELAMBDA_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey PAREN =
            createTextAttributesKey("ELAMBDA_PAREN", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey BRACE =
            createTextAttributesKey("ELAMBDA_BRACE", DefaultLanguageHighlighterColors.BRACES);

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] PAREN_KEYS = new TextAttributesKey[]{PAREN};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACE};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new ELambdaLexerAdapter();
    }

    @Override
    public @NotNull TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ELambdaTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(ELambdaTypes.KW_DATA)
                || tokenType.equals(ELambdaTypes.KW_LAM)
                || tokenType.equals(ELambdaTypes.KW_CASE)
                || tokenType.equals(ELambdaTypes.KW_OF)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(ELambdaTypes.PAR_LEFT) || tokenType.equals(ELambdaTypes.PAR_RIGHT)) {
            return PAREN_KEYS;
        } else if (tokenType.equals(ELambdaTypes.CURLY_LEFT) || tokenType.equals(ELambdaTypes.CURLY_RIGHT)) {
            return BRACE_KEYS;
        }
        return EMPTY_KEYS;
    }
}
