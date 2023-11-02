<template>
  <div>
    <h2>Upload Image</h2>
    <form @submit.prevent="uploadImage">
      <label>Select Image:
        <input type="file" ref="fileInput" required>
      </label>
      <br><br>
      <br><br>
      <button type="submit">Upload</button>
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
    //upload the album cover Image to the backend
    uploadImage() {
      //return FormData to match the backend requirement
      const formData = new FormData();
      const fileInput = this.$refs.fileInput;

      //upload image
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

