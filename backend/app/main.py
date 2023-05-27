from fastapi import FastAPI
from transformers import pipeline


model = pipeline(
    task='question-answering',
    model='timpal0l/mdeberta-v3-base-squad2')

context = None

app = FastAPI()


@app.get('/')
def read_root():
    return {'Deafault': 'Start Page'}


@app.get('/set_context/')
def set_context(text: str = 'default'):
    global context
    if text == 'default':
        with open('sources/about.txt', 'r', encoding='utf-8') as file:
            context = file.read()
    else:
        context = text
    return {'Message': context}


@app.get('/get_answer/')
def get_answer(question: str):
    global context
    if context is None:
        with open('sources/about.txt', 'r', encoding='utf-8') as file:
            context = file.read()
    answer = model(question=question, context=context)['answer']
    answer = ' '.join(answer.split(' ')).capitalize()
    return {'answer': answer}
