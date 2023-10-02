<template>
  <div>
    <!-- 文件上传 -->
    <input type="file" ref="fileInput" />
    <input type="text" v-model="description" placeholder="Description" />
    <button @click="uploadFile">Upload</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      description: ''
    };
  },
  methods: {
    async uploadFile() {
      const file = this.$refs.fileInput.files[0];
      if (file && this.description) {
        const formData = new FormData();
        formData.append('file', file);
        formData.append('description', this.description);

        try {
          const response = await fetch('/api/images', {
            method: 'POST',
            body: formData,
          });

          if (!response.ok) {
            throw new Error(`Upload failed: ${response.statusText}`);
          }

          const image = await response.json();
          console.log('File uploaded:', image);
        } catch (error) {
          console.error(error.message);
        }
      } else {
        alert('Please select a file and enter a description.');
      }
    },
  },
};
</script>
