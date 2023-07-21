import os
from langchain import OpenAI
from langchain.chains.summarize import load_summarize_chain
from langchain.chains import AnalyzeDocumentChain
from langchain.text_splitter import CharacterTextSplitter
from langchain.chains.question_answering import load_qa_chain
import scrapy

os.environ["OPENAI_API_KEY"] = "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"
# https://www.toutiao.com/article/7237465072535208463

class DmozSpider(scrapy.Spider):

    start_urls = [
        "https://www.toutiao.com/article/7237465072535208463"
    ]

    def parse(self, response):
        filename = response.url.split("/")[-2]
        with open(filename, 'wb') as f:
            f.write(response.body)

TEXT_URL = './toutiao/text_txt.txt'
# 定义使用的模型
CHAIN_TYPE = "refine"
with open(TEXT_URL, 'r', encoding='utf-8') as f:
  state_of_the_union = f.read()
llm = OpenAI(temperature=0)
# 定义文本分割器 每块文本大小为500，不重叠
text_splitter = CharacterTextSplitter(
    chunk_size = 1500,
    chunk_overlap  = 0,
    length_function = len,
)
# 生成摘要
summary_chain = load_summarize_chain(llm, chain_type=CHAIN_TYPE)
summarize_document_chain = AnalyzeDocumentChain(combine_docs_chain=summary_chain, text_splitter=text_splitter)
res = summarize_document_chain.run(state_of_the_union)
print(res)