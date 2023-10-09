<template>
  <div>
    <h2>图片上传</h2>
    <form @submit.prevent="uploadImage">
      <label>选择图片:
        <input type="file" ref="fileInput" required>
      </label>
      <br><br>
      <label>图片描述:
        <textarea v-model="description" rows="4" cols="50"></textarea>
      </label>
      <br><br>
      <button type="submit">上传</button>
    </form>
  </div>
</template>

<script>
import {post} from "@/net";
import {ElMessage} from "element-plus";

export default {
  data() {
    return {
      description: ''
    };
  },
  methods: {
    uploadImage() {
      const formData = new FormData();
      const fileInput = this.$refs.fileInput;

      if (fileInput.files.length > 0) {
        formData.append('file', fileInput.files[0]);
        formData.append('description', this.description);
        post('/api/image/upload', formData, (message) => {
          ElMessage.success(message)
        })
      }else {
        ElMessage.warning("please select image")
      }
    }
  }
}
</script>

