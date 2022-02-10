package com.github.andreypfau.intellijton.func.psi

import com.intellij.psi.PsiElement

interface FuncElement : PsiElement
//
//open class FuncElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), FuncElement {
//}
//
//interface FuncNamedElement : FuncElement, PsiNameIdentifierOwner
//interface FuncReferenceElement : FuncNamedElement {
//    val referenceNameElement: PsiElement
//    val referenceName: String
//        get() = referenceNameElement.text
//
//    override fun getReference(): FuncReference?
//}
//
//abstract class FuncNamedElementImpl(node: ASTNode) : FuncElementImpl(node), FuncNamedElement {
//    override fun getNameIdentifier(): PsiElement? = findChildByType(FuncTypes.IDENTIFIER)
//    override fun getName(): String? = nameIdentifier?.text
//    override fun setName(name: String): PsiElement = apply {
//        nameIdentifier?.replace(project.funcPsiFactory.createIdentifier(name))
//    }
//
//    override fun getNavigationElement(): PsiElement = nameIdentifier ?: this
//    override fun getTextOffset(): Int = nameIdentifier?.textOffset ?: super.getTextOffset()
//}
//
//interface FuncFunctionCallElement : FuncReferenceElement {
//}
//
//abstract class FuncFunctionCallMixin(
//    node: ASTNode
//) : FuncNamedElementImpl(node), FuncFunctionCallElement, FuncFunctionCallExpression {
//    override val referenceNameElement: PsiElement
//        get() = when (val expr = expression) {
//            is FuncPrimaryExpression -> expr.varLiteral ?: expr.primitiveTypeName!!
//            is FuncMemberAccessExpression -> expr.memberAccessIdentifier
//            is FuncModifierAccessExpression -> expr.firstChild
//            is FuncFunctionCallElement -> expr.referenceNameElement
//            else -> error("Can't extract reference name element for expression: $expr")
//        }
//
//    override fun getReference(): FuncReference? = null
//}
//
//interface FuncVarLiteralElement : FuncReferenceElement
//abstract class FuncVarLiteralMixin(
//    node: ASTNode
//) : FuncNamedElementImpl(node), FuncVarLiteralElement, FuncVarLiteral {
//    override val referenceNameElement: PsiElement
//        get() = nameIdentifier!!
//
//    override fun getReference() = FuncVarLiteralReference(this)
//}
//
//abstract class FuncFunctionDefinitionMixin(node: ASTNode) : FuncNamedElementImpl(node), FuncFunctionDefinition {
//    var isBuiltIn: Boolean = false
//    override fun getNameIdentifier(): PsiElement? = functionIdentifier.identifier
//    override fun canNavigate(): Boolean = !isBuiltIn
//    override fun canNavigateToSource(): Boolean = !isBuiltIn
//
//    override fun getIcon(flags: Int): Icon = FuncIcons.FUNCTION
//
//    override fun getPresentation(): ItemPresentation? {
//        val name = name ?: return null
//        return PresentationData(
//            name,
//            null,
//            FuncIcons.FUNCTION,
//            TextAttributesKey.createTextAttributesKey("public")
//        )
//    }
//}
//
//abstract class FuncParameterDefMixin(node: ASTNode) : FuncNamedElementImpl(node), FuncParameterDef {
//    override fun getNameIdentifier(): PsiElement? = parameterIdentifier?.identifier
//
//    override fun toString(): String = if (name != null) {
//        typeName.text + " " + name
//    } else typeName.text
//}
//
//abstract class FuncReturnDefMixin(node: ASTNode) : FuncElementImpl(node), FuncReturnDef {
//    override fun toString(): String {
//        val typeName = typeName
//        val typeNameList = typeNameList
//        if (typeName != null) {
//           return typeName.text
//        }
//        if (typeNameList != null) {
//           return typeNameList.typeNameItemList.asSequence().map { it.typeName?.text }.filterNotNull().joinToString()
//        }
//        if (placeholder != null) {
//            return "_"
//        }
//        return ""
//    }
//}