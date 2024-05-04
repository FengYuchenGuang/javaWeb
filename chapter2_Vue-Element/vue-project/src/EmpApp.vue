<template>
  <div>
    <!-- 员工管理 -->
    <!-- <nav>
      <router-link to="/dept">Home</router-link> |
      <router-link to="/emp">About</router-link>
    </nav> -->

    <router-view></router-view>
    
  </div>
</template>

<script>
// import EmpView from './views/tlias/EmpView.vue'
export default {
  components: {/* EmpView */},
  data() {
    return {
      message: "Hello vue222"
    }
  },
  methods: {
    
  }
}
</script>

<style>

</style>
