<script setup>

import { ref } from 'vue'

const comments = ref([{id: 1, author: "John Doe", date: "2021-01-01", body: "This is a comment."},
  {id: 2, author: "Jane Doe", date: "2021-01-02", body: "This is another comment."}])

</script>

<template>
    <div>
        <h1>Comments</h1>
        <div class="comments">
            <div class="comment" v-for="comment in comments" :key="comment.id">
                <div class="comment-header">
                    <div class="comment-author">{{ comment.author }}</div>
                    <div class="comment-date">{{ comment.date }}</div>
                </div>
                <div class="comment-body">{{ comment.body }}</div>
            </div>
        </div>
    </div>
</template>

<style scoped>
h1{
  font-family: Futura, "Trebuchet MS", Arial, sans-serif;
    font-size: 1.5rem;
    font-weight: bold;
    margin-bottom: 1rem;
}

.comments{
    display: flex;
    flex-direction: column;
    gap: 1rem;
}

.comment{
    display: flex;
    flex-direction: column;
    gap: 0.5rem;
    padding: 1rem;
    border: 1px solid #ccc;
    border-radius: 0.5rem;
}

.comment-header{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
}

.comment-author{
  font-family: Futura, "Trebuchet MS", Arial, sans-serif;
  font-size: 1rem;
  font-weight: bold;
}

.comment-date{
    font-size: 0.8rem;
    color: #666;
}

.comment-body{
  font-family: Futura, sans-serif;
  font-size: 1rem;
}
</style>