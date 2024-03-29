import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from 'vuex-persistedstate';
import auth from "@/store/modules/auth";

Vue.use(Vuex)

const store = new Vuex.Store({
    modules:{
        auth
    },
    plugins: [createPersistedState({paths: ["auth"]})]
})

export default store;