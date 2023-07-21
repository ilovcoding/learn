import os
from langchain.chains import LLMChain
from langchain.prompts import PromptTemplate
from langchain.llms import OpenAI

os.environ["OPENAI_API_KEY"] = "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"
llm = OpenAI()

prompt = PromptTemplate(
    input_variables=["product"],
    template="What is a good name for a company that makes {product}?",
)

promptZhCN = PromptTemplate(
    input_variables=["product"],
    template="一个好名字对于做{product}的公司?",
)


chain = LLMChain(llm=llm, prompt=prompt)
print(prompt.format(product="cars"))
print(chain.run("cards"))
print("\n****************************\n")
zhCN_Chain = LLMChain(llm=llm, prompt=promptZhCN)
print(promptZhCN.format(product="汽车"))
print(zhCN_Chain.run("汽车"))