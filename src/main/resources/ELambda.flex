package com.github.lambdamix.elambda;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

import static com.github.lambdamix.elambda.ELambdaTypes.*;

%%

%{
  public ELambdaLexer() {
    this((java.io.Reader)null);
  }
%}


%class ELambdaLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

ControlCharacter = [\000 - \037]
WhitespaceChar = [ \t\n\xa0] | {ControlCharacter}
Whitespace = {WhitespaceChar}+

END_OF_LINE_COMMENT=("--")[^\r\n]*

Uppercase = [A-Z]
Lowercase = [a-z]
Letter = {Uppercase} | {Lowercase}
Digit = [0-9]

NameChar = {Letter} | {Digit}

NameChars = {NameChar}*

UId = {Uppercase} {NameChars}
LId = {Lowercase} {NameChars}

%%

<YYINITIAL> {END_OF_LINE_COMMENT}
      { return COMMENT; }

<YYINITIAL> {Whitespace}
      { return com.intellij.psi.TokenType.WHITE_SPACE; }

<YYINITIAL> "lam"
      { return KW_LAM; }

<YYINITIAL> "case"
      { return KW_CASE; }

<YYINITIAL> "data"
      { return KW_DATA; }

<YYINITIAL> "of"
      { return KW_OF; }

<YYINITIAL> "where"
      { return KW_WHERE; }

<YYINITIAL>  "("
      { return PAR_LEFT; }

<YYINITIAL>  ")"
      { return PAR_RIGHT; }

<YYINITIAL>  "{"
      { return CURLY_LEFT; }

<YYINITIAL>  "}"
      { return CURLY_RIGHT; }

<YYINITIAL>  "->"
      { return ARROW; }

<YYINITIAL>  ";"
      { return SEMI; }

<YYINITIAL>  "."
      { return DOT; }

<YYINITIAL>  ","
      { return COMMA; }

<YYINITIAL>  "|"
      { return OP_OR; }

<YYINITIAL> "="
      { return OP_EQ; }

<YYINITIAL>  "->"
      { return ARROW; }

<YYINITIAL> {UId}
      { return UID; }

<YYINITIAL> {LId}
      { return LID; }

[^]
      {return com.intellij.psi.TokenType.BAD_CHARACTER; }
